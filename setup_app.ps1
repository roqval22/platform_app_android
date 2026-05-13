# Script para instanciar una nueva App desde la base
# Ejecución: ./setup_app.ps1 -AppName "Mi Nueva App" -AppId "com.empresa.app"

param (
    [string]$AppName,
    [string]$AppId
)

if (-not $AppName -or -not $AppId) {
    Write-Host "Error: Debes proporcionar -AppName y -AppId" -ForegroundColor Red
    Write-Host "Ejemplo: ./setup_app.ps1 -AppName 'SuperApp' -AppId 'com.test.superapp'"
    exit
}

Write-Host "--- Configurando nueva App: $AppName ($AppId) ---" -ForegroundColor Cyan

# 1. Actualizar build_cfg.gradle.kts
$buildCfgPath = "app/build_cfg.gradle.kts"
(Get-Content $buildCfgPath) -replace 'project.extra.set\("app_id", ".*"\)', "project.extra.set(`"app_id`", `"$AppId`")" | Set-Content $buildCfgPath
Write-Host "[OK] build_cfg.gradle.kts actualizado."

# 2. Actualizar AppCfg.kt
$appCfgPath = "app/src/main/java/com/example/platformapp/core/cfg/AppCfg.kt"
(Get-Content $appCfgPath) -replace 'const val APP_NAME = ".*"', "const val APP_NAME = `"$AppName`"" | Set-Content $appCfgPath
Write-Host "[OK] AppCfg.kt actualizado."

Write-Host ""
Write-Host "PASOS FINALES:" -ForegroundColor Yellow
Write-Host "1. Coloca el archivo 'google-services.json' de tu nuevo proyecto Firebase en la carpeta /app/"
Write-Host "2. En Android Studio, haz clic en el botón de 'Sync Project with Gradle Files' (el icono del elefante)."
Write-Host "3. ¡Listo! La app ya tiene su nueva identidad." -ForegroundColor Green
