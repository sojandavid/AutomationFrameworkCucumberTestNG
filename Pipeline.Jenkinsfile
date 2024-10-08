pipeline {

    options {
        buildDiscarder logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5')
    }

    agent any

    environment {
            PATH = "/opt/homebrew/Cellar/maven/3.9.4/libexec/bin:${env.PATH}"
    }

    stages {

        stage('Automation Test') {
            steps{
                sh 'mvn clean test'
            }
        }

    }

}