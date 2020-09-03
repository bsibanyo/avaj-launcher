find -name *.java > sources.txt
javac -sourcepath . @sources.txt
cd src/
echo "$(tput setaf 2)Classes have been created successfully, Mr Bruce."
echo "$(tput setaf 1)"
java weather.Simulator scenario.txt

  echo $(tput setaf 2)
  cat simulator.txt;

cd ..