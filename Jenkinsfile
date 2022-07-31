pipeline {
    agent {
        label 'master'
    }

    triggers { pollSCM('H */4 * * 1-5') }

    parameters {
        string(name: 'rp_endpoint', defaultValue: 'http://10.114.0.3:8080/')
        string(name: 'rp_bearer_token')
    }

    stages {
        stage('Test') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'rp-superadmin', passwordVariable: 'rp_password', usernameVariable: 'rp_login')]) {
                    withGradle {
                        sh "chmod +x gradlew"
                        sh "./gradlew clean te[]st -Drp_endpoint=${rp_endpoint} -Ddriver='chrome'"
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