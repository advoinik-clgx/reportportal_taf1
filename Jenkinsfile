pipeline {
    agent {
        label 'master'
    }

    triggers { pollSCM('H/5 * * * *') }

    parameters {
        choice(name: 'browser', choices: ['chrome', 'firefox'])
        string(name: 'rp_endpoint', defaultValue: 'http://10.114.0.3:8080/')
        string(name: 'rp_bearer_token')
    }

    stages {
        stage('Test') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'rp-superadmin', passwordVariable: 'rp_password', usernameVariable: 'rp_login')]) {
                    withGradle {
                        sh "chmod +x gradlew"
                        sh "./gradlew clean test -Drp_endpoint=${rp_endpoint} -Dweb_driver=$browser"
                    }
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