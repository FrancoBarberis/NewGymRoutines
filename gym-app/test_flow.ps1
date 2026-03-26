$ErrorActionPreference = "Stop"

Write-Host "Starting Spring Boot..."
Start-Process -FilePath ".\mvnw.cmd" -ArgumentList "spring-boot:run" -PassThru

Write-Host "Waiting 15 seconds for app to start..."
Start-Sleep -Seconds 15

Write-Host "Registering user..."
$response = Invoke-RestMethod -Uri "http://localhost:8080/users/register" -Method Post -ContentType "application/json" -Body '{"nombre": "Test", "email": "test@mail.com", "password": "pass"}'
Write-Host "User register response: $($response | ConvertTo-Json)"

Write-Host "Getting the token from DB via test script or just checking if it was saved..."
