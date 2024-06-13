Get-ChildItem -directory -name -recurse -filter bin > foldersToRemove.txt
&git rm -r @(cat .\foldersToRemove.txt)
Get-ChildItem -directory -name -recurse -filter out > foldersToRemove.txt
&git rm -r @(cat .\foldersToRemove.txt)
Get-ChildItem -directory -name -recurse -filter .idea > foldersToRemove.txt
&git rm -r @(cat .\foldersToRemove.txt)
Get-ChildItem -directory -name -recurse -filter target > foldersToRemove.txt
&git rm -r @(cat .\foldersToRemove.txt)
Get-ChildItem -directory -name -recurse -filter node_modules > foldersToRemove.txt
&git rm -r @(cat .\foldersToRemove.txt)
Get-ChildItem -directory -name -recurse -filter .DS_Store > foldersToRemove.txt
&git rm -r @(cat .\foldersToRemove.txt)
Get-ChildItem -file -name -recurse -filter *.sln > foldersToRemove.txt
&git rm -r @(cat .\foldersToRemove.txt)
Get-ChildItem -name -recurse -filter logs > foldersToRemove.txt
Get-ChildItem -name -recurse -filter *.log >> foldersToRemove.txt
&git rm -r @(cat .\foldersToRemove.txt)

Get-ChildItem -name -recurse -filter dist > foldersToRemove.txt
&git rm -r @(cat .\foldersToRemove.txt)
Get-ChildItem -file -name -recurse -filter *.suo > foldersToRemove.txt
&git rm -r @(cat .\foldersToRemove.txt)

