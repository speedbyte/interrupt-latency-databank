from xml.dom import minidom

#------------------------File to be parsed--------------------------

doc = minidom.parse('ChargePointService-soapui-project.xml')

#print doc.toxml()
#print doc.childNodes

#------------------------Accessing child nodes----------------------

docNode = doc.childNodes[1]
docNode.childNodes

#print docNode.toxml()
#print docNode.childNodes[3].toxml()

typeNode = docNode.childNodes[3]
typeNode.childNodes

#print typeNode.childNodes[1].toxml()

schNode = typeNode.childNodes[1]
schNode.childNodes


#print schNode.childNodes[3].toxml()
print schNode.childNodes[3]

int3Node = schNode.childNodes[3]
int3Node.childNodes

#print int3Node.childNodes[3].toxml()

doc3Mode = int3Node.childNodes[3]
doc3Mode.childNodes

print doc3Mode.childNodes[1].toxml()

int5Node = schNode.childNodes[5]
int5Node.childNodes

print int5Node

doc5Mode = int5Node.childNodes[3]
doc5Mode.childNodes

print doc5Mode.childNodes[1].toxml()
print doc5Mode.childNodes[3].toxml()
print doc5Mode.childNodes[5].toxml()
print doc5Mode.childNodes[7].toxml()
print doc5Mode.childNodes[9].toxml()

int7Node = schNode.childNodes[7]
int7Node.childNodes

print int7Node

doc7Mode = int7Node.childNodes[1]
doc7Mode.childNodes

print doc7Mode.childNodes[1].toxml()
print doc7Mode.childNodes[3].toxml()
print doc7Mode.childNodes[5].toxml()

int11Node = schNode.childNodes[11]
int11Node.childNodes

print int11Node

doc11Mode = int11Node.childNodes[3]
doc11Mode.childNodes

print doc11Mode.childNodes[1].toxml()
print doc11Mode.childNodes[3].toxml()

int13Node = schNode.childNodes[13]
int13Node.childNodes

print int13Node

doc13Mode = int13Node.childNodes[3]
doc13Mode.childNodes

print doc13Mode.childNodes[1].toxml()

int15Node = schNode.childNodes[15]
int15Node.childNodes

print int15Node

doc15Mode = int15Node.childNodes[3]
doc15Mode.childNodes

print doc15Mode.childNodes[1].toxml()

int17Node = schNode.childNodes[17]
int17Node.childNodes

print int17Node

doc17Mode = int17Node.childNodes[3]
doc17Mode.childNodes

print doc17Mode.childNodes[1].toxml()
print doc17Mode.childNodes[3].toxml()

int19Node = schNode.childNodes[19]
int19Node.childNodes

print int19Node

doc19Mode = int19Node.childNodes[3]
doc19Mode.childNodes

print doc19Mode.childNodes[1].toxml()

int21Node = schNode.childNodes[21]
int21Node.childNodes

print int21Node

doc21Mode = int21Node.childNodes[3]
doc21Mode.childNodes

print doc21Mode.childNodes[1].toxml()
print doc21Mode.childNodes[3].toxml()

int23Node = schNode.childNodes[23]
int23Node.childNodes

print int23Node

doc23Mode = int23Node.childNodes[1]
doc23Mode.childNodes

print doc23Mode.childNodes[1].toxml()

int25Node = schNode.childNodes[25]
int25Node.childNodes

print int25Node

doc25Mode = int25Node.childNodes[3]
doc25Mode.childNodes

print doc25Mode.childNodes[1].toxml()
print doc25Mode.childNodes[3].toxml()

int27Node = schNode.childNodes[27]
int27Node.childNodes

print int27Node

doc27Mode = int27Node.childNodes[3]
doc27Mode.childNodes

print doc27Mode.childNodes[1].toxml()
print doc27Mode.childNodes[3].toxml()

int29Node = schNode.childNodes[29]
int29Node.childNodes

print int29Node

doc29Mode = int29Node.childNodes[3]
doc29Mode.childNodes

print doc29Mode.childNodes[1].toxml()
print doc29Mode.childNodes[3].toxml()
print doc29Mode.childNodes[5].toxml()

int31Node = schNode.childNodes[31]
int31Node.childNodes

print int31Node

doc31Mode = int31Node.childNodes[3]
doc31Mode.childNodes

print doc31Mode.childNodes[1].toxml()

int33Node = schNode.childNodes[33]
int33Node.childNodes

print int33Node

doc33Mode = int33Node.childNodes[3]
doc33Mode.childNodes

print doc33Mode.childNodes[1].toxml()
print doc33Mode.childNodes[3].toxml()
print doc33Mode.childNodes[5].toxml()
print doc33Mode.childNodes[7].toxml()
print doc33Mode.childNodes[9].toxml()

int35Node = schNode.childNodes[35]
int35Node.childNodes

print int35Node

doc35Mode = int35Node.childNodes[3]
doc35Mode.childNodes

print doc35Mode.childNodes[1].toxml()

int37Node = schNode.childNodes[37]
int37Node.childNodes

print int37Node

int39Node = schNode.childNodes[39]
int39Node.childNodes

print int39Node

doc39Mode = int39Node.childNodes[3]
doc39Mode.childNodes

print doc39Mode.childNodes[1].toxml()
print doc39Mode.childNodes[3].toxml()

int41Node = schNode.childNodes[41]
int41Node.childNodes

print int41Node

doc41Mode = int41Node.childNodes[3]
doc41Mode.childNodes

print doc41Mode.childNodes[1].toxml()

int43Node = schNode.childNodes[43]
int43Node.childNodes

print int43Node

doc43Mode = int43Node.childNodes[1]
doc43Mode.childNodes

print doc43Mode.childNodes[1].toxml()
print doc43Mode.childNodes[3].toxml()
print doc43Mode.childNodes[5].toxml()
print doc43Mode.childNodes[7].toxml()

int45Node = schNode.childNodes[45]
int45Node.childNodes

print int45Node

int47Node = schNode.childNodes[47]
int47Node.childNodes

print int47Node

doc47Mode = int47Node.childNodes[3]
doc47Mode.childNodes

print doc47Mode.childNodes[1].toxml()
print doc47Mode.childNodes[3].toxml()

int49Node = schNode.childNodes[49]
int49Node.childNodes

print int49Node

doc49Mode = int49Node.childNodes[3]
doc49Mode.childNodes

print doc49Mode.childNodes[1].toxml()
print doc49Mode.childNodes[3].toxml()
print doc49Mode.childNodes[5].toxml()

int51Node = schNode.childNodes[51]
int51Node.childNodes

print int51Node

doc51Mode = int51Node.childNodes[3]
doc51Mode.childNodes

print doc51Mode.childNodes[1].toxml()

int53Node = schNode.childNodes[53]
int53Node.childNodes

print int53Node

doc53Mode = int53Node.childNodes[3]
doc53Mode.childNodes

print doc53Mode.childNodes[1].toxml()
print doc53Mode.childNodes[3].toxml()

int55Node = schNode.childNodes[55]
int55Node.childNodes

print int55Node

doc55Mode = int55Node.childNodes[3]
doc55Mode.childNodes

print doc55Mode.childNodes[1].toxml()
print doc55Mode.childNodes[3].toxml()

int57Node = schNode.childNodes[57]
int57Node.childNodes

print int57Node

doc57Mode = int57Node.childNodes[3]
doc57Mode.childNodes

print doc57Mode.childNodes[1].toxml()

int59Node = schNode.childNodes[59]
int59Node.childNodes

print int59Node

doc59Mode = int59Node.childNodes[3]
doc59Mode.childNodes

print doc59Mode.childNodes[1].toxml()

int61Node = schNode.childNodes[61]
int61Node.childNodes

print int61Node

doc61Mode = int61Node.childNodes[3]
doc61Mode.childNodes

print doc61Mode.childNodes[1].toxml()

int63Node = schNode.childNodes[63]
int63Node.childNodes

print int63Node

doc63Mode = int63Node.childNodes[3]
doc63Mode.childNodes

print doc63Mode.childNodes[1].toxml()

int65Node = schNode.childNodes[65]
int65Node.childNodes

print int65Node

doc65Mode = int65Node.childNodes[1]
doc65Mode.childNodes

print doc65Mode.childNodes[1].toxml()
print doc65Mode.childNodes[3].toxml()

int67Node = schNode.childNodes[67]
int67Node.childNodes

print int67Node

doc67Mode = int67Node.childNodes[3]
doc67Mode.childNodes

print doc67Mode.childNodes[1].toxml()

int69Node = schNode.childNodes[69]
int69Node.childNodes

print int69Node

doc69Mode = int69Node.childNodes[3]
doc69Mode.childNodes

print doc69Mode.childNodes[1].toxml()
print doc69Mode.childNodes[3].toxml()
print doc69Mode.childNodes[5].toxml()

int71Node = schNode.childNodes[71]
int71Node.childNodes

print int71Node

doc71Mode = int71Node.childNodes[3]
doc71Mode.childNodes

print doc71Mode.childNodes[1].toxml()
print doc71Mode.childNodes[3].toxml()
print doc71Mode.childNodes[5].toxml()
print doc71Mode.childNodes[7].toxml()

int73Node = schNode.childNodes[73]
int73Node.childNodes

print int73Node

doc73Mode = int73Node.childNodes[3]
doc73Mode.childNodes

print doc73Mode.childNodes[1].toxml()
print doc73Mode.childNodes[3].toxml()

int75Node = schNode.childNodes[75]
int75Node.childNodes

print int75Node

doc75Mode = int75Node.childNodes[3]
doc75Mode.childNodes

print doc75Mode.childNodes[1].toxml()

int77Node = schNode.childNodes[77]
int77Node.childNodes

print int77Node

doc77Mode = int77Node.childNodes[3]
doc77Mode.childNodes

print doc77Mode.childNodes[1].toxml()
print doc77Mode.childNodes[3].toxml()
print doc77Mode.childNodes[5].toxml()

int79Node = schNode.childNodes[79]
int79Node.childNodes

print int79Node

doc79Mode = int79Node.childNodes[3]
doc79Mode.childNodes

print doc79Mode.childNodes[1].toxml()
print doc79Mode.childNodes[3].toxml()

int81Node = schNode.childNodes[81]
int81Node.childNodes

print int81Node

int83Node = schNode.childNodes[83]
int83Node.childNodes

print int83Node

doc83Mode = int83Node.childNodes[3]
doc83Mode.childNodes

print doc83Mode.childNodes[1].toxml()

int85Node = schNode.childNodes[85]
int85Node.childNodes

print int85Node

doc85Mode = int85Node.childNodes[3]
doc85Mode.childNodes

print doc85Mode.childNodes[1].toxml()
print doc85Mode.childNodes[3].toxml()
print doc85Mode.childNodes[5].toxml()
print doc85Mode.childNodes[7].toxml()
print doc85Mode.childNodes[9].toxml()

int87Node = schNode.childNodes[87]
int87Node.childNodes

print int87Node

doc87Mode = int87Node.childNodes[1]
doc87Mode.childNodes

print doc87Mode.childNodes[1].toxml()
print doc87Mode.childNodes[3].toxml()
print doc87Mode.childNodes[5].toxml()
print doc87Mode.childNodes[7].toxml()
print doc87Mode.childNodes[9].toxml()

int89Node = schNode.childNodes[89]
int89Node.childNodes

print int89Node

doc89Mode = int89Node.childNodes[3]
doc89Mode.childNodes

print doc89Mode.childNodes[1].toxml()

int91Node = schNode.childNodes[91]
int91Node.childNodes

print int91Node

doc91Mode = int91Node.childNodes[1]
doc91Mode.childNodes

print doc91Mode.childNodes[1].toxml()
print doc91Mode.childNodes[3].toxml()

int93Node = schNode.childNodes[93]
int93Node.childNodes

print int93Node

doc93Mode = int93Node.childNodes[1]
doc93Mode.childNodes

print doc93Mode.childNodes[1].toxml()
print doc93Mode.childNodes[3].toxml()

int95Node = schNode.childNodes[95]
int95Node.childNodes

print int95Node

doc95Mode = int95Node.childNodes[3]
doc95Mode.childNodes

print doc95Mode.childNodes[1].toxml()
print doc95Mode.childNodes[3].toxml()
print doc95Mode.childNodes[5].toxml()
print doc95Mode.childNodes[7].toxml()

int97Node = schNode.childNodes[97]
int97Node.childNodes

print int97Node

doc97Mode = int97Node.childNodes[1]
doc97Mode.childNodes

print doc97Mode.childNodes[1].toxml()
print doc97Mode.childNodes[3].toxml()
print doc97Mode.childNodes[5].toxml()
print doc97Mode.childNodes[7].toxml()
print doc97Mode.childNodes[9].toxml()

int99Node = schNode.childNodes[99]
int99Node.childNodes

print int99Node

doc99Mode = int99Node.childNodes[3]
doc99Mode.childNodes

print doc99Mode.childNodes[1].toxml()
print doc99Mode.childNodes[3].toxml()

int101Node = schNode.childNodes[101]
int101Node.childNodes

print int101Node.toxml()

int103Node = schNode.childNodes[103]
int103Node.childNodes

print int103Node.toxml()

int105Node = schNode.childNodes[105]
int105Node.childNodes

print int105Node.toxml()

int107Node = schNode.childNodes[107]
int107Node.childNodes

print int107Node.toxml()


int109Node = schNode.childNodes[109]
int109Node.childNodes

print int109Node.toxml()

int111Node = schNode.childNodes[111]
int111Node.childNodes

print int111Node.toxml()

int113Node = schNode.childNodes[113]
int113Node.childNodes

print int113Node.toxml()

int115Node = schNode.childNodes[115]
int115Node.childNodes

print int115Node.toxml()

int117Node = schNode.childNodes[117]
int117Node.childNodes

print int117Node.toxml()

int119Node = schNode.childNodes[119]
int119Node.childNodes

print int119Node.toxml()

int121Node = schNode.childNodes[121]
int121Node.childNodes

print int121Node.toxml()

int123Node = schNode.childNodes[123]
int123Node.childNodes

print int123Node.toxml()

int125Node = schNode.childNodes[125]
int125Node.childNodes

print int125Node.toxml()

int127Node = schNode.childNodes[127]
int127Node.childNodes

print int127Node.toxml()

int129Node = schNode.childNodes[129]
int129Node.childNodes

print int129Node.toxml()

int131Node = schNode.childNodes[131]
int131Node.childNodes

print int131Node.toxml()

int133Node = schNode.childNodes[133]
int133Node.childNodes

print int133Node.toxml()

int135Node = schNode.childNodes[135]
int135Node.childNodes

print int135Node.toxml()

int137Node = schNode.childNodes[137]
int137Node.childNodes

print int137Node.toxml()

int139Node = schNode.childNodes[139]
int139Node.childNodes

print int139Node.toxml()

int141Node = schNode.childNodes[141]
int141Node.childNodes

print int141Node.toxml()

int143Node = schNode.childNodes[143]
int143Node.childNodes

print int143Node.toxml()

int145Node = schNode.childNodes[145]
int145Node.childNodes

print int145Node.toxml()

int147Node = schNode.childNodes[147]
int147Node.childNodes

print int147Node.toxml()

int149Node = schNode.childNodes[149]
int149Node.childNodes

print int149Node.toxml()

int151Node = schNode.childNodes[151]
int151Node.childNodes

print int151Node.toxml()

int153Node = schNode.childNodes[153]
int153Node.childNodes

print int153Node.toxml()

int155Node = schNode.childNodes[155]
int155Node.childNodes

print int155Node.toxml()

int157Node = schNode.childNodes[157]
int157Node.childNodes

print int157Node.toxml()

int159Node = schNode.childNodes[159]
int159Node.childNodes

print int159Node.toxml()

int161Node = schNode.childNodes[161]
int161Node.childNodes

print int161Node.toxml()