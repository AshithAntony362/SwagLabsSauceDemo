pipeline {
    agent any

    stages {
        stage('Valid-InvalidLogin') {
            steps {
                checkout scm
            }
        }

        stage('Run Regression Tests') {
            steps {
                bat 'mvn clean test -DsuiteXmlFile=regression-testng.xml'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
    }
}