package com.wm.utils


def npmInstall(){
    if (params.GithubRepo == "https://github.com/prashant4875/Netflix-clone.git"){
        echo "Environment is ${params.Environment}"
        sh 'npm install'
    }
    else{
        echo "This repo is ${params.GithubRepo}"
    }
}