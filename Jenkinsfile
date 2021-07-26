pipeline {
	//Donde se va a ejecutar el Pipeline
	agent {
		label 'Slave_Induccion'
	}

    //Opciones específicas de Pipeline dentro del Pipeline
	options {
		buildDiscarder(logRotator(numToKeepStr: '3')) //Número maximo de ejecuciones a guardar
		disableConcurrentBuilds() //No permitir compilaciones simultaneas
	}

	//Una sección que define las herramientas "preinstaladas" en Jenkins
	tools {
		jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
		gradle 'Gradle5.6_Centos' //Preinstalada en la Configuración del Master
	}

    //Acciones automáticas
	triggers {
		pollSCM('@hourly') //Periodo de tiempo en el que revisa el repositorio para ejecutar pipeline
		                    //cada vez que encuentre un cambio
	}

    //Aquí comienzan los "items" del Pipeline
	stages{
		stage('Checkout') {
			steps{
				echo "------------>Checkout<------------"
				checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [],
                    gitTool: 'Default',
                    submoduleCfg: [],
                    userRemoteConfigs: [[
                        credentialsId: 'GitHub_AngelMarin',
                        url: 'https://github.com/castrillon899/generacion-solicitudes.git'
				    ]]
				])
				sh 'gradle --b ./ADN-SolicitudesBackend/java-arquitectura-hexagonal/microservicio/build.gradle clean' //Asegurar no tener datos basura de compilaciones anteriores
			}
		}

		stage('Compile') {
			steps{
				echo "------------>Compile<------------"
				sh 'gradle --b ./ADN-SolicitudesBackend/java-arquitectura-hexagonal/microservicio/build.gradle compileJava'
			}
		}

		stage('Unit Tests And Coverage') {
			steps{
				echo "------------>Unit Tests<------------"
				sh 'gradle --b ./ADN-SolicitudesBackend/java-arquitectura-hexagonal/build.gradle test'
				junit '**/build/test-results/test/*.xml' //Agregar los resultados del test a Junit
			    sh 'gradle --b ./ADN-SolicitudesBackend/java-arquitectura-hexagonal/build.gradle jacocoTestReport'
			}
		}

		stage('Static Code Analysis') {
			steps{
				echo '------------>Static Code Analysis<------------'
				withSonarQubeEnv('Sonar') {
					sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
				}
			}
		}

		stage('Build') {
			steps {
				echo "------------>Build<------------"
                sh 'gradle --b ./ADN-SolicitudesBackend/java-arquitectura-hexagonal/build.gradle build -x test' //Construir sin tarea test que se ejecutó previamente
			}
		}
	}

	post {
		always {
			echo 'This will always run'
		}
		success {
			echo 'This will run only if successful'
		}
		failure {
			echo 'This will run only if failed'
			//send notifications about a Pipeline to an email
			mail (to: 'andres.montoya@ceiba.com.co',
			      subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
			      body: "Something is wrong with ${env.BUILD_URL}")
		}
		unstable {
			echo 'This will run only if the run was marked as unstable'
		}
		changed {
			echo 'This will run only if the state of the Pipeline has changed'
			echo 'For example, if the Pipeline was previously failing but is now successful'
		}
	}
}