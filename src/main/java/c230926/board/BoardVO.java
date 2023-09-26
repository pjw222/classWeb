package c230926.board;

public class BoardVO {
	private int id;
	private String name;
	private String boardName;
	private String content;
	
	public BoardVO(
			int id,
			String name,
			String boardName,
			String content

			)
	{
		this.id = id;
		this.name = name;
		this.boardName = boardName;
		this.content = content;

	}
	public int getId() {return id;}
	public String getName() {return name;}
	public String getBoardName() {return boardName;}
	public String getContent() {return content;}
}
