git add .
echo -n "[+] Enter your commit message: "
read msg;
git commit -m "$msg"
git push -u origin master;