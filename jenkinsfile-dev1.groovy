@Library('shared') _
properties([
    parameters([
        choice(name: 'Environment', choices: ['dev', 'sit2'], description: 'The target environment'),
        choice(name: 'GithubRepo', choices: ['https://github.com/prashant4875/two-tier-flask-app'], description: 'Select Github repo to checkout'),
        gitParameter(
            name: 'Branch',
            branchFilter: "origin/develop|origin/release.*",
            defaultValue: 'master',
            sortMode: 'DESCENDING_SMART',
            type: 'PT_BRANCH',
            useRepository: 'https://github.com/prashant4875/two-tier-flask-app.git'
        )
    ])
])
dev()