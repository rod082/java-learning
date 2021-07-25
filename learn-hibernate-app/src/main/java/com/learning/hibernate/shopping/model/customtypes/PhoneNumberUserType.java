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

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.learning.hibernate.shopping.utils.DataUtils;

public class PhoneNumberUserType implements UserType, StringRepresentableType<PhoneNumber>, Serializable {
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
	public String toString(PhoneNumber value) throws HibernateException {
		return value.toString();
	}

	@Override
	public Class<?> returnedClass() {
		return PhoneNumber.class;
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.VARCHAR };
	}

	@Override
	public PhoneNumber fromStringValue(String number) throws HibernateException {
		try {
			return PhoneNumberUtil.getInstance().parse(number, "US");
		} catch (NumberParseException e) {
			throw new HibernateException(e);
		}
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		final String number = rs.getString(names[0]);
		if (number == null) {
			return null;
		}
		return DataUtils.parsePhoneNumber(number);
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.VARCHAR);
			return;
		}
		st.setString(index, DataUtils.formatPhoneNumber((PhoneNumber) value));
	}
}