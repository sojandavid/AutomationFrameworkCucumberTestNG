pipeline {

    options {
        buildDiscarder logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5')
    }

    agent any

    environment {
            PATH = "/usr/local/bin:/path/to/maven/bin:${env.PATH}"
    }

    stages {

        stage('Automation Test') {
            steps{
                sh 'mvn clean test'
            }
        }

    }

}