def collectSlaveInfo(){
    echo "Collect Slave Info"
    sh 'whoami'
    sh 'hostname'
    sh 'date'
    sh 'df -h'
    sh 'npm install -g aws-cdk'
}