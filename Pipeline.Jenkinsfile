pipeline {

    options {
        buildDiscarder logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5')
    }

    agent any

    stages {

        stage('Check properties') {
            steps {
                sh 'mvn -version'
                sh 'java -version'
            }
        }

        stage('Automation Test') {
            steps{
                sh 'mvn clean test -U'
            }
        }

    }

}