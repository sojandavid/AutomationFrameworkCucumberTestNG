pipeline {

    options {
        buildDiscarder logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5')
    }

    agent any

    stages {

        stage('Check properties') {
            steps {
                bat 'mvn -version'
                bat 'java -version'
            }
        }

        stage('Automation Test') {
            steps{
                bat 'mvn clean test -U'
            }
        }

    }

    cleanup {
        cleanWs(notFailBuild: true)
    }

}