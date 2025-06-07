import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

version = "2021.2"

project {
    buildType(MyRandomNumber)
}

object MyRandomNumber : BuildType({
    name = "Restore and Publish .NET App"

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
            scriptContent = "dotnet publish -c Release -o ./publish"
        }
    }

    artifactRules = "publish/**/* => published.zip"
})
