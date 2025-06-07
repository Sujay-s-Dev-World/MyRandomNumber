import jetbrains.buildServer.configs.kotlin.v2019_2.*

version = "2021.2"

project {
    buildType(DotnetRestoreAndPublish)
}

object DotnetRestoreAndPublish : BuildType({
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
            scriptContent = """
                dotnet publish -o ./build
            """.trimIndent()
        }
    }

    artifactRules = "+:./build => MyRandomNumber_Artifact.zip"

    triggers {
        vcs {
            branchFilter = "+:develop"
        }
    }
})
