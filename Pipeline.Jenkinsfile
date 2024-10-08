pipeline {

    options {
        buildDiscarder logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5')
    }

    agent any

    tools {
            maven 'Maven 3.x' // Ensure that 'Maven 3.x' matches the name configured in Jenkins
        }

    stages {

        stage('Automation Test') {
            steps{
                sh 'mvn clean test'
            }
        }

    }

}