grammar DpathGrammar;



     /**Grammar Rule*/



dpath : node  NodeAttributeSeparator relation RelationSeparator  node NodeAttributeSeparator EOF #startTwoNodes
  | node NodeAttributeSeparator relation EOF #startNodeRel
  | node EOF #startNode

  ;
  /**The EOF symbol appears in a grammar to force processing of all tokens in a file/
   * String.if EOF is not used  it means we are not trying to parse the entire input,
   * and it's acceptable to parse only a portion of the input even at the cost of
   * avoiding a syntax error.
   */


node : (aspectName) NodeAttributeSeparator (bindingName NameVersionSeparator bindingVersion) NodeAttributeSeparator (entityName NameVersionSeparator entityVersion) (NodeAttributeSeparator miqWithEv)?  #nodeWithEV
	|   (aspectName) NodeAttributeSeparator (bindingName NameVersionSeparator bindingVersion) NodeAttributeSeparator (entityName) (NodeAttributeSeparator miqWithoutEv)? #nodeWithoutEV
	;

miqWithEv: MiqOpeningDelimiter ('miq://document:'  documentVersion ) NodeAttributeSeparator (aspectName) NodeAttributeSeparator (bindingName MiqNameVersionSeparator bindingVersion) NodeAttributeSeparator (entityName MiqNameVersionSeparator entityVersion)NodeAttributeSeparator id MiqClosingDelimiter;

miqWithoutEv: MiqOpeningDelimiter  ('miq://document:' documentVersion ) NodeAttributeSeparator (aspectName) NodeAttributeSeparator (bindingName MiqNameVersionSeparator bindingVersion) NodeAttributeSeparator (entityName ) NodeAttributeSeparator id MiqClosingDelimiter;

relation : relationName RelationSeparator relation   #relation1
  | relationName  					  				 #relation2
  ;


relationName:Word;

aspectName:Word;

bindingName:Word;

entityName:Word;

bindingVersion:FloatValue;

entityVersion:FloatValue;

documentVersion:FloatValue;

id:Word;




     /**Tokens*/

NodeAttributeSeparator: '/'  ;

RelationSeparator : '>' ;

Whitespace : [ \t\r\n]+ -> skip ;

NameVersionSeparator:  '::';

MiqNameVersionSeparator:  ':';

//MiqAttributeSeparator: '/';

FloatValue : [0-9]+  '.' [0-9]+  ;

MiqOpeningDelimiter: '[';

MiqClosingDelimiter: ']';

Word: [a-z A-Z 0-9 '_' \- ]+;
