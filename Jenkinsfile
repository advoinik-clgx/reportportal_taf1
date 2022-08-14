pipeline {
    agent {
        label 'master'
    }

    options {
        ansiColor('xterm')
    }

    triggers { pollSCM('H/5 * * * *') }

    parameters {
        choice(name: 'browser', choices: ['firefox', 'chrome'])
        string(name: 'rp_endpoint', defaultValue: 'http://68.183.214.91:8080/')
    }

    stages {
        stage('Test') {
            tools {
                jdk "openjdk-17"
            }
            steps {
                withCredentials([usernamePassword(
                        credentialsId: 'api_user',
                        passwordVariable: 'rp_api_password',
                        usernameVariable: 'rp_api_user')]) {
                    sh "chmod +x gradlew"
                    sh "./gradlew clean test -Drp_endpoint=${rp_endpoint} -Dweb_driver=$browser -Dselenoid_url=3.66.110.100 --info"
                }
            }
        }
    }
    post {
        always {
            allure results: [
                    [path: 'build/allure-results']
            ]
        }
    }
}