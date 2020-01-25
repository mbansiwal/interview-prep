import java.util.ArrayDeque;
import java.util.Deque;

/*
 * s=raw_input()
spaces=2
t=''
for ch in s:
	if ch==' ':
		continue
	if ch=='[':
		print spaces*' '+ch
		spaces+=2
	elif ch==']':
		if t!='':
			print spaces*' '+t
		        t=''
		spaces-=2
		print spaces*' '+ch
	elif ch==',':
		if t=='':`
			print ch
		else:
			print spaces*' '+t+','
			t=''
	elif ch=='{' or ch=='}':
		print ch	 
	else:
		t+=ch
 */
public class PrettyPrintJson
{
	static void printJsonString(String jsonStr)
	{
		if (jsonStr == null || jsonStr.trim().length() == 0)
		{
			System.out.println(jsonStr);
			return;
		}
		final String ret = "\n";
		StringBuilder formattedJson = new StringBuilder();
		StringBuilder spaces = new StringBuilder();
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < jsonStr.length();)
		{
			char c = jsonStr.charAt(i);
			switch (c)
			{
			case '{':
			case '[':
				stack.push(c);
				spaces.append("\t");
				formattedJson.append(c).append(ret).append(spaces);
				i++;
				break;
			case '}':
			case ']':
				stack.pop();
				spaces.deleteCharAt(spaces.length() - 1);
				formattedJson.append(ret).append(spaces).append(c);
				i++;
				if (!(i < jsonStr.length() && (jsonStr.charAt(i) == ',' || jsonStr.charAt(i) == '}' || jsonStr.charAt(i) == ']')))
				{
					formattedJson.append(ret).append(spaces);
				}
				break;
			case ',':
				formattedJson.append(c).append(ret).append(spaces);
				i++;
				break;
			default:
				formattedJson.append(c);
				i++;
				break;
			}
		}
		System.out.println(formattedJson);
	}

	static void printJSON(String str)
	{
		int space = 2;
		int i = 1;
		int n = str.length() - 1;
		System.out.println(str.charAt(0));
		while (i < n)
		{
			int sp = 0;
			if (str.charAt(i) == '[')
			{
				sp = space;
				space += 2;
			} else
			{
				if (str.charAt(i) == ']')
				{
					space = space - 2;
					sp = space;
				} else
				{
					sp = space;
				}
			}
			while (sp > 0)
			{
				System.out.print(' ');
				sp--;
			}
			System.out.print(str.charAt(i));
			if (i < n && str.charAt(i + 1) == ',')
			{
				System.out.print(',');
				i++;
			}
			System.out.println();
			i++;
		}
		System.out.println(str.charAt(n));
	}

	public static void main(String[] args)
	{
		String text = "{\"id\": \"0001\", \"type\": \"donut\",\"name\": \"Cake\",\"ppu\": 0.55, \"batters\":{\"batter\":[{ \"id\": \"1001\", \"type\": \"Regular\" },{ \"id\": \"1002\", \"type\": \"Chocolate\" }]},\"topping\":[{ \"id\": \"5001\", \"type\": \"None\" },{ \"id\": \"5002\", \"type\": \"Glazed\" }]}";
		 printJsonString(text);
//		printJSON(text);
	}
}
