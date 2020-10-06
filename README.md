## Data_Engeneering

### TEST
Veuillez copier chacune des lignes de code ci-dessous et le coller dans MsdBatchMain
en effectuant la procédure suivante: MsdBatchMain => Edit Configurations => Program arguments

#### lire json parser en xml
-r src\Data\reader_json.json   -p src\Data\persister_xml.json -rt json -pt xml 

#### lire csv parser en xml
-r src\Data\reader_csv.json   -p src\Data\persister_xml.json -rt csv -pt xml 

#### lire json parser csv
-r src\Data\reader_json.json   -p src\Data\persister_csv.json -rt json -pt csv
 
#### lire xml parser en json
-r src\Data\reader_xml.json   -p src\Data\persister_json.json -rt xml -pt json 
