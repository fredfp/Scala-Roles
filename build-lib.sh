#!/bin/sh

# -Xexperimental required for dependent method types
scalac -d bin/ `find src/ -name "*.scala"`

