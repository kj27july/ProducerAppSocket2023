Write-Host "Enter the desired package name"
$package = Read-Host

Write-Host "Enter the desired App name"
$appname = Read-Host

$packagearr = $package.Split(".")

$pathdir = Get-Location

$patharray = @("$pathdir\app\src\main\java\net\soti\yoursocket\SocketApp.kt",
               "$pathdir\app\src\main\java\net\soti\yoursocket\controllers\CollectionController.kt",
 	       "$pathdir\app\src\main\java\net\soti\yoursocket\controllers\XtsBuilder.kt",
 	       "$pathdir\app\src\main\java\net\soti\yoursocket\features\DataList.kt",
 	       "$pathdir\app\src\main\java\net\soti\yoursocket\ui\MainActivity.kt",
	       "$pathdir\app\src\androidTest\java\net\soti\yoursocket\ExampleInstrumentedTest.kt",
	       "$pathdir\app\src\test\java\net\soti\yoursocket\ExampleUnitTest.kt",
	       "$pathdir\app\build.gradle")

$patharrayapp= @("$pathdir\settings.gradle",
		 "$pathdir\app\src\main\res\values\strings.xml")

$patharrayrename= @("$pathdir\app\src\main\java\net\soti\yoursocket\",
		    "$pathdir\app\src\main\java\net\soti\",
		    "$pathdir\app\src\main\java\net\",
		    "$pathdir\app\src\androidTest\java\net\soti\yoursocket\",
		    "$pathdir\app\src\androidTest\java\net\soti\",
                    "$pathdir\app\src\androidTest\java\net\",
		    "$pathdir\app\src\test\java\net\soti\yoursocket\",
		    "$pathdir\app\src\test\java\net\soti\",
		    "$pathdir\app\src\test\java\net\")
		
for ($i = 0; $i -lt $patharray.Length; $i++) {
(Get-Content $patharray[$i]) | Foreach-Object {
    $_ -replace "net.soti.yoursocket", $package
} | Set-Content $patharray[$i]
}

for ($i = 0; $i -lt $patharrayapp.Length; $i++) {
(Get-Content $patharrayapp[$i]) | Foreach-Object {
    $_ -replace "XT Socket BP", $appname
} | Set-Content $patharrayapp[$i]
}

for ($i = 0; $i -lt $patharrayrename.Length; $i = $i+3) {
Rename-Item -Path  $patharrayrename[$i] -NewName $packagearr[2]
Rename-Item -Path  $patharrayrename[$i+1] -NewName $packagearr[1]
Rename-Item -Path  $patharrayrename[$i+2] -NewName $packagearr[0]
}

Write-Output "Refactoring Successful"
pause
