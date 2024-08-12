var notes= window.__INITIAL_STATE__.user.notes._rawValue[0]

document.open();document.close();
for(var i=0;i<notes.length;i++) {
	var note = notes[i]
	var note_id = note.id
	var line = `https://www.xiaohongshu.com/explore/${note_id}`
	document.write(line);
    document.write("<br>")
	if((i+1)%10==0){
		document.write("<br>")
	}
}
