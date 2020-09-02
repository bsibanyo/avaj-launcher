find -name *.java > sources.txt
javac @sources.txt
cd src/
echo "$(tput setaf 2)Classes created successfully"
echo "$(tput setaf 1)"
java Simulator scenario.txt
if [ $? == 0 ]; then
  echo "$(tput setaf 2)"
  cat -e simulation.txt;
fi