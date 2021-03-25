import json

jfile = open('C:\\Users\\jml75\\Desktop\\Website projects\\Bonus Bot\\json files\\Trash\\TRASH-9.json', encoding='utf8')
jsondata = jfile.read()

obj = json.loads(jsondata)

bonuses= obj.get("data").get("bonuses")

f = open("C:\\Users\\jml75\\Desktop\\Website projects\\Bonus Bot\\txt files\\Trash\\TRASH-9.txt", "w", encoding='utf8')

for i in range(len(bonuses)):
    f.write(bonuses[i].get("leadin") + "\n")
    f.write(bonuses[i].get("texts")[0] + "\n")
    f.write(bonuses[i].get("texts")[1] + "\n")
    f.write(bonuses[i].get("texts")[2] + "\n")
    f.write(bonuses[i].get("answers")[0] + "\n")
    f.write(bonuses[i].get("answers")[1] + "\n")
    f.write(bonuses[i].get("answers")[2] + "\n")



