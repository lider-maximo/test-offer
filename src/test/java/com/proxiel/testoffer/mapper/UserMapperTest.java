package com.proxiel.testoffer.mapper;

import com.proxiel.testoffer.data.User;
import com.proxiel.testoffer.dto.UserDTO;
import com.proxiel.testoffer.utils.InstanceFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * User Mapper unit tests
 *
 * @author Hassan Jroundi
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {

    /**
     * Map User to DTO test.
     *
     * @result DTO
     */
    @Test
    public void whenMapUsertoUserDto_thenOk() {

        User user = InstanceFactory.user;

        UserDTO userDTO = UserMapper.INSTANCE.entityToDto(user);

        assertEquals(user.getId(), userDTO.getId());
        assertEquals(user.getLogin(), userDTO.getLogin());
        assertEquals(user.getPassword(), userDTO.getPassword());

    }

    /**
     * Map null User to DTO test.
     *
     * @result null DTO
     */
    @Test
    public void whenMapNullUsertoUserDto_thenReturnNull() {

        User user = null;
        UserDTO userDTO = UserMapper.INSTANCE.entityToDto(user);

        assertNull(user);
        assertNull(userDTO);

    }

    /**
     * Map User List to DTO List test.
     *
     * @result DTO List
     */
    @Test
    public void whenMapUserListToUserDtoList_thenOk() {

        List<User> userList = InstanceFactory.users;

        List<UserDTO> userDTOList = UserMapper.INSTANCE.entitiesToDTOs(userList);

        assertEquals(userList.get(0).getId(), userDTOList.get(0).getId());
        assertEquals(userList.get(0).getLogin(), userDTOList.get(0).getLogin());
        assertEquals(userList.get(0).getPassword(), userDTOList.get(0).getPassword());

    }

    /**
     * Map null User List to DTO List test.
     *
     * @result null DTO List
     */
    @Test
    public void whenMapNullUserListToUserDtoList_thenReturnNull() {

        List<User> userList = null;
        List<UserDTO> userDTOList = UserMapper.INSTANCE.entitiesToDTOs(userList);

        assertNull(userList);
        assertNull(userDTOList);

    }

    /**
     * Map User DTO to User test.
     *
     * @result User
     */
    @Test
    public void whenMapUserDtoToUser_thenOk() {

        UserDTO userDTO = InstanceFactory.userDTO;
        User user = UserMapper.INSTANCE.dtoToEntity(userDTO);

        assertEquals(user.getId(), userDTO.getId());
        assertEquals(user.getLogin(), userDTO.getLogin());
        assertEquals(user.getPassword(), userDTO.getPassword());

    }

    /**
     * Map null UserDTO to User test.
     *
     * @result null User
     */
    @Test
    public void whenMapNullUserDtoToUser_thenReturnNull() {

        UserDTO userDTO = null;
        User user = UserMapper.INSTANCE.dtoToEntity(userDTO);

        assertNull(user);
        assertNull(userDTO);

    }

    /**
     * Map UserDTO List to User List test.
     *
     * @result User List
     */
    @Test
    public void whenMapUserListDtoToUserList_thenOk() {

        List<UserDTO> userDTOList = InstanceFactory.usersDTO;
        List<User> userList = UserMapper.INSTANCE.dtosToEntities(userDTOList);

        assertEquals(userList.get(0).getId(), userDTOList.get(0).getId());
        assertEquals(userList.get(0).getLogin(), userDTOList.get(0).getLogin());
        assertEquals(userList.get(0).getPassword(), userDTOList.get(0).getPassword());

    }

    /**
     * Map null UserDTO List to User List test.
     *
     * @result null User List
     */
    @Test
    public void whenMapNullUserDtoListToUserList_thenReturnNull() {

        List<UserDTO> userDTOList = null;
        List<User> userList = UserMapper.INSTANCE.dtosToEntities(userDTOList);

        assertNull(userList);
        assertNull(userDTOList);

    }
}
