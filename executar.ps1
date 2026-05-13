# =========================================================
# SCRIPT: executar.ps1
# PROJETO: Café Expresso
# DESCRIÇÃO:
# Script responsável por compilar e executar o sistema.
# =========================================================

Clear-Host

Write-Host "================================="
Write-Host " COMPILANDO PROJETO..."
Write-Host "================================="

if (!(Test-Path "bin")) {
    New-Item -ItemType Directory -Path "bin"
}

javac -d bin `
src/main/aplicacao/Main.java `
src/main/modelo/*.java `
src/main/enumeracao/*.java `
src/main/constante/*.java

if ($LASTEXITCODE -ne 0) {
    Write-Host ""
    Write-Host "ERRO NA COMPILACAO!"
    exit
}

Write-Host ""
Write-Host "================================="
Write-Host " EXECUTANDO SISTEMA..."
Write-Host "================================="
Write-Host ""

java -cp bin aplicacao.Main