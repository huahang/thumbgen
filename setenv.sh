#!/usr/bin/env bash

_find_root () {
  local dir
  dir=$PWD;
  while [ "$dir" != "/" ]; do
    if [ -f "$dir/.thumbgen_root" ]; then
      echo "$dir"
      return 0
    fi;
    dir=`dirname "$dir"`
  done
  return 1
}

# use java 1.8
OS=$(uname -s)
if [[ $OS == *"Darwin"* ]]; then
  export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
fi

# use maven 3.6.0
export ROOT=$(_find_root)
export PATH=$ROOT/software/maven/apache-maven-3.6.0/bin:$PATH
