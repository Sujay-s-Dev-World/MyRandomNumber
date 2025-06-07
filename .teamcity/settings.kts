import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

project {
    buildType {
        id("Dotnet_Build")
        name = "Dotnet Restore and Publish"

        vcs {
            root(DslContext.settingsRoot)
        }

        steps {
            script {
                name = "Dotnet Restore"
                scriptContent = "dotnet restore"
            }
            script {
                name = "Dotnet Publish"
                scriptContent = "dotnet publish -o ./build"
            }
        }
    }
}
