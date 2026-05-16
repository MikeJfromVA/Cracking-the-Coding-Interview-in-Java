#!/usr/bin/env python3
"""Compile the repo and run the select_random demo (SelectRandom.main — no JUnit tests)."""
import subprocess
import sys
import urllib.request
from pathlib import Path

REPO = Path(__file__).resolve().parents[2]
JUNIT = REPO / "junit.jar"
OUT = REPO / "out"
JUNIT_URL = (
    "https://repo1.maven.org/maven2/org/junit/platform/"
    "junit-platform-console-standalone/1.11.4/"
    "junit-platform-console-standalone-1.11.4.jar"
)
JAVAC = "javac"
JAVA = "java"
MAIN_CLASS = "select_random.SelectRandom"

if not JUNIT.exists():
    print("Downloading junit.jar ...")
    urllib.request.urlretrieve(JUNIT_URL, JUNIT)

OUT.mkdir(exist_ok=True)
sources = [str(p) for p in (REPO / "src").rglob("*.java")]
subprocess.run([JAVAC, "-cp", str(JUNIT), "-d", str(OUT), *sources], check=True)

run = subprocess.run([JAVA, "-cp", str(OUT), MAIN_CLASS])
sys.exit(run.returncode)
