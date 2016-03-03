#!/bin/bash

cd RestService

x-terminal-emulator -e mvn exec:java

cd ..

sleep 5

cd Loader

java -cp . jsikora.App
