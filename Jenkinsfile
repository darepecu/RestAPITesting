pipeline {
    agent any

    parameters {
        choice(name: 'Enviroment',
        choices: 'dev\nstg\nprd',
        description: 'Ambiente donde se correran las pruebas.')
    }

    tools {
        gradle 'Gradle-6.5.1'
        jdk 'JDK'
    }

    stages {

        stage('Test') {
            steps {
                echo 'Building..'
                withGradle {
                  sh "gradle clean test aggregate -Dcucumber.options='--tags @regression' -Denvironment=${params.Enviroment}"
                }
            }
        }

        stage('Report') {
            steps {

                echo 'Reporting....'
                // publish the Serenity report

                publishHTML(target: [
                        reportName : 'Serenity',
                        reportDir:   'target/site/serenity',
                        reportFiles: 'index.html',
                        keepAll:     true,
                        alwaysLinkToLastBuild: true,
                        allowMissing: false,
                        reportName: "Serenity Report"
                ])

            }
        }
    }
}
