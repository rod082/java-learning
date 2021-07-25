package com.learning.hibernate.shopping.model.customtypes;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.StringRepresentableType;
import org.hibernate.usertype.UserType;

import com.learning.hibernate.shopping.model.UserRole;

public class UserRoleType implements UserType, StringRepresentableType<UserRole>, Serializable {
	
	private static final long serialVersionUID = -364436436346432L;

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return x != null ? x.equals(y) : y == null;
	}

	@Override
	public int hashCode(Object object) throws HibernateException {
		return object.hashCode();
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, Object value) throws HibernateException {
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

	@Override
	public String toString(UserRole value) throws HibernateException {
		return value.toString();
	}

	@Override
	public Class<?> returnedClass() {
		return UserRole.class;
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.INTEGER };
	}

	@Override
	public UserRole fromStringValue(String str) throws HibernateException {
		return UserRole.valueOf(str);
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		int roleId = rs.getInt(names[0]);
		return UserRole.valueOf(roleId);
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.INTEGER);
			return;
		}
		st.setInt(index, ((UserRole) value).code());
	}
}