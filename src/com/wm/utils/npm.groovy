package com.wm.utils


def npmInstall(){
    echo "Environment is ${params.Environment}"
    sh 'npm install'
}