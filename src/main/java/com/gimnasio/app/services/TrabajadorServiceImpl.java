package com.gimnasio.app.services;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gimnasio.app.models.Trabajador;
import com.gimnasio.app.repository.TrabajadorRepository;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

	@Autowired
	private TrabajadorRepository trabajadorRepository;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

	
	@Override
	public List<Trabajador> listarTrabajadores() {
		// TODO Auto-generated method stub
		return trabajadorRepository.findAll();
	}

	@Override
	public Trabajador buscarTrabajadorPorId(Long id) {
		// TODO Auto-generated method stub
		return trabajadorRepository.findById(id).orElse(new Trabajador());
	}

	@Override
	public void eliminarTrabajador(Long idTrabajador) {
		// TODO Auto-generated method stub
		trabajadorRepository.deleteById(idTrabajador);
		
	}

	@Override
	public Trabajador crearTrabajador(Trabajador trabajador) {
		// TODO Auto-generated method stub
		trabajador.setPassword(passwordEncoder.encode(trabajador.getPassword()));
		return trabajadorRepository.save(trabajador);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Trabajador trabajador = trabajadorRepository.findByCorreo(username);
		if(trabajador == null) {
	        throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(trabajador.getCorreo(),
	            trabajador.getPassword(),
	            getAuthorities(trabajador));
	   	}

	@Override
	public Trabajador findByCorreo(String correo) {
		return trabajadorRepository.findByCorreo(correo);
		
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(Trabajador trabajador) {
        String[] userRoles = {trabajador.getRole().toString()};
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
	
}
