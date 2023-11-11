package org.jbtech.app;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jbtech.app.model.Film;
import org.jbtech.app.repository.FilmRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Path("/")
public class FileResource {

    @Inject
    FilmRepository filmRepository;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello JBTech";
    }

    @GET
    @Path("/film/{filmId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFilm(short filmId) {
        Optional<Film> film = filmRepository.getFilm(filmId);
        return film.isPresent() ? film.get().getTitle() : "No film Found!";
    }

    @GET
    @Path("/pagedFilms/{page}/{minLength}")
    @Produces(MediaType.TEXT_PLAIN)
    public String paged(long page, short minLength) {
        return filmRepository.paged(page, minLength)
                .map(film -> String.format("%s (%d min)", film.getTitle(), film.getLength()))
                .collect(Collectors.joining("\n"));
    }

    @GET
    @Path("/actors/{startWith}/{minLength}")
    @Produces(MediaType.TEXT_PLAIN)
    public String paged(String startWith, short minLength) {
        return filmRepository.actors(startWith, minLength)
                .map(film -> String.format("%s (%d min): %s",
                        film.getTitle(),
                        film.getLength(),
                        film.getActors().stream()
                                .map(actor -> String.format("%s %s", actor.getFirstName(), actor.getLastName()))
                                .collect(Collectors.joining("\n"))))
                .collect(Collectors.joining("\n"));
    }
}
