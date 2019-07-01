package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger
{

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

class NestedIntegerImpl implements NestedInteger
{
	Integer integer;

	public NestedIntegerImpl()
	{
		super();
	}

	public NestedIntegerImpl(Integer integer)
	{
		super();
		this.integer = integer;
	}

	List<NestedInteger> list;

	public NestedIntegerImpl(List<NestedInteger> list)
	{
		super();
		this.list = list;
	}

	@Override
	public Integer getInteger()
	{
		return integer;
	}

	@Override
	public List<NestedInteger> getList()
	{
		return list;
	}

	@Override
	public boolean isInteger()
	{
		return list == null && integer != null;
	}
}

public class NestedIterator implements Iterator<Integer>
{
	private Iterator<NestedInteger> iterator;
	private NestedIterator innerIterator;

	public NestedIterator(List<NestedInteger> nestedList)
	{
		if (nestedList != null)
		{
			Iterator<NestedInteger> tempIterator = nestedList.iterator();
			while (tempIterator.hasNext())
			{
				NestedInteger tempInteger = tempIterator.next();
				if (!tempInteger.isInteger() && (tempInteger.getList() == null || tempInteger.getList().isEmpty()))
				{
					tempIterator.remove();
				}
			}
			this.iterator = nestedList.iterator();
			if (!nestedList.isEmpty())
			{
				if (!nestedList.get(0).isInteger())
				{
					iterator.next();
					innerIterator = new NestedIterator(nestedList.get(0).getList());
				}
			}
		}
	}

	@Override
	public Integer next()
	{
		if (innerIterator != null && innerIterator.hasNext())
		{
			return innerIterator.next();
		}

		if (iterator.hasNext())
		{
			NestedInteger nestedInteger = iterator.next();
			if (!nestedInteger.isInteger() && !nestedInteger.getList().isEmpty())
			{
				innerIterator = new NestedIterator(nestedInteger.getList());
				if (innerIterator.hasNext())
				{
					return innerIterator.next();
				}
			}
			else
			{
				return nestedInteger.getInteger();
			}

		}
		return null;
	}

	@Override
	public boolean hasNext()
	{
		if (iterator.hasNext())
		{
			return true;
		}

		if (innerIterator != null)
		{
			return innerIterator.hasNext();
		}
		return false;
	}

	public static void main(String[] args)
	{
		// List<NestedInteger> nestedList = new ArrayList<>();
		// List<NestedInteger> element1 = new ArrayList<>();
		// element1.add(new NestedIntegerImpl(1));
		// element1.add(new NestedIntegerImpl(1));
		// nestedList.add(new NestedIntegerImpl(element1));
		// nestedList.add(new NestedIntegerImpl(2));
		//
		// List<NestedInteger> element2 = new ArrayList<>();
		// element2.add(new NestedIntegerImpl(1));
		// element2.add(new NestedIntegerImpl(1));
		// nestedList.add(new NestedIntegerImpl(element2));
		
		// NestedIterator iterator = new NestedIterator(nestedList);
		// while (iterator.hasNext())
		// {
		// System.out.println(iterator.next());
		// }

		List<NestedInteger> nestedList2 = new ArrayList<>();
		List<NestedInteger> element3 = new ArrayList<>();
		element3.add(new NestedIntegerImpl(1));
		nestedList2.add(new NestedIntegerImpl(element3));
		nestedList2.add(new NestedIntegerImpl());
		
		List<NestedInteger> element4 = new ArrayList<>();
		element4.add(new NestedIntegerImpl(new ArrayList<>()));
		nestedList2.add(new NestedIntegerImpl(element4));
		NestedIterator iterator2 = new NestedIterator(nestedList2);
		while (iterator2.hasNext())
		{
			System.out.println(iterator2.next());
		}

	}
}
