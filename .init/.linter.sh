#!/bin/bash
cd /home/kavia/workspace/code-generation/communicreate-pictogram-builder-172101-172112/backend
./gradlew checkstyleMain
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi

