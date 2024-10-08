pipeline {

    options {
        buildDiscarder logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5')
    }

    agent any

   stages {

        stage('Automation Test') {
            steps{
                sh "mvn clean test"
            }
        }

    }

}