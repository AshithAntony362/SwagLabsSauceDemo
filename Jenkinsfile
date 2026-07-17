pipeline {
    agent any

    tools {
        jdk 'JDK'
    }

    stages {
        stage('Run Regression Tests') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
                bat 'mvn clean test -DsuiteXmlFile=regression-testng.xml'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true,
                  testResults: 'target/surefire-reports/*.xml'
        }
    }
}