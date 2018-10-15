Dim count
count = 0
sFolder = "FilePath"
Set oFSO = CreateObject("Scripting.FileSystemObject")
For each oFile In oFSO.GetFolder(sFolder).Files
	If(Instr(oFSO.GetFileName(oFile),"Index")=0 And (Instr(oFSO.GetFileName(oFile), ".html"))>0) Then
		oFSO.DeleteFile oFile.Path
		count = count + 1
	End If
Next
msgbox count & " files deleted."