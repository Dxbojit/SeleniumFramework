pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven-3.9.12'
    }

    environment {
        HEADLESS = 'true'
        TAGS = '@smoke'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Dxbojit/SeleniumFramework.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh '''
                    mvn clean test \
                    -Dcucumber.filter.tags=${TAGS} \
                    -Dheadless=${HEADLESS}
                '''
            }
        }
    }

    post {

        always {
            echo 'Publishing reports...'
        }

        success {
            echo 'Build successful!'
        }

        failure {
            echo 'Build failed!'
        }
    }
}
