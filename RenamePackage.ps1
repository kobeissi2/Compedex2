#Script to rename the package and files to the user inputted name.

$baseAppDir = ".\app\src\main\java"
$basePackageName = "com.kobeissidev.androidtemplate"
Write-Host ""
Write-Host "Note: This will only rename from the base package name: $basePackageName"
Write-Host ""
$packageName = Read-Host 'What is your package name? Should be separated by periods to create the new directories'

function UpdatePackageName {
    Write-Host ""
    Write-Host "Updating package name in KT and XML files"

    $files = Get-ChildItem .\ -recurse | Where-Object { $_.extension -in ".xml", ".kt" }

    foreach ($file in $files) {
        (Get-Content $file.PSPath) |
        Foreach-Object { $_ -replace $basePackageName, $packageName } |
        Set-Content $file.PSPath
    }

    Write-Host ""
    Write-Host "Done updating package name"
}

function UpdateDirectories {
    Write-Host ""
    Write-Host "Updating directories"

    $baseDir = $basePackageName.Replace('.', '\')
    $packageNameSplit = $packageName.Split('.')
    $newDir = ""

    foreach ($file in $packageNameSplit) {
        $newDir += "\" + $file
    }

    New-Item -ItemType Directory -Path $baseAppDir$newDir -Force
    Get-ChildItem -Path $baseAppDir\$baseDir | Copy-Item -Destination $baseAppDir$newDir -Container -Recurse
    Remove-Item -LiteralPath $baseAppDir\$baseDir -Force -Recurse

    Write-Host ""
    Write-Host "Done updating directories with path: $($newDir)"
}

function Quit {
    Write-Host ""
    Write-Host "Done! Feel free to delete this script."
    Write-Host ""
    Write-Host -NoNewLine 'Press any key to continue...';
    $null = $Host.UI.RawUI.ReadKey('NoEcho,IncludeKeyDown');
}


if ($packageName.Length -eq 0) {
    Quit
}
else {
    UpdatePackageName
    UpdateDirectories
    Quit
}