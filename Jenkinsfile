pipeline {
    agent any

    parameters{
        choice(name: 'TAGS', choices: ['@regression','@smoke'] , description: 'Select the tag to run tests for')
        boolean(name: 'HEADLESS', defaultValue: true, description: 'Run tests in headless mode')
        choice(name: 'BROWSER', choices: ['chrome','firefox'] , description: 'Select the browser to run tests on')
    }

    tools {
        jdk 'JDK-17'
        maven 'Maven-3.9.12'
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
                bat """
                    mvn clean test ^
                    -Dcucumber.filter.tags=%TAGS% ^
                    -Dheadless=%HEADLESS%
                    -Dbrowser=%BROWSER%
                """
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
