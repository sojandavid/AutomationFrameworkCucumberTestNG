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

    post {
            always {
                cucumber fileIncludePattern: '**/*.json',
                         failedStepsNumber: 1,
                         skippedStepsNumber: 0,
                         pendingStepsNumber: 0,
                         undefinedStepsNumber: 0,
                         failedFeaturesNumber: 0,
                         buildStatus: 'FAILURE'
            }
//             success {
//                     archiveArtifacts artifacts: '/reports/CucumberReports/cucumber-reports/cucumber-html-reports/'
//                 }
//             }
        }

}