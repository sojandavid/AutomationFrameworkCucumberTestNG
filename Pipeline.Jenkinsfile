pipeline {

    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }

//    triggers {
//        cron('30 4 * * 2')
//    }

    parameters {
        choice(
                name: 'ScenarioThreadCount',
                choices: [
                        '1',
                        '2',
                        '3',
                ],
                description: 'Scenario Threadcount')
        string(name: 'TestSuitNo', defaultValue: 'TS-2558', description: 'TestSuiteNo')
    }

    agent any

    stages {

        stage('Check properties') {
            steps {
                bat 'mvn -version'
                bat 'java -version'
            }
        }

//         stage('Automation Test') {
//             steps{
//                 configFileProvider([configFile(fileId:'MavenGlobalSettings', variable: 'MAVEN_SETTINGS_XML')]) {
//                     bat "mvn -s $MAVEN_SETTINGS_XML clean test -U -Dqtest_project_name=FD -Dscenario_threadcount=${params.ScenarioThreadCount} -Doverride_result=true -Dqtest_test_ids=${params.TestSuiteNo}"
//                 }
//             }
//         }

        stage('Automation Test') {
            steps{
                bat "mvn clean test -U"
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
        success {
                archiveArtifacts allowEmptyArchive: true, artifacts: '/reports/CucumberReports/cucumber-reports/cucumber-html-reports/*/', '/reports/CucumberExtentReports/', fingerprint: true
            }
        }
    }

    cleanup {
        cleanWs(notFailBuild: true)
    }

}