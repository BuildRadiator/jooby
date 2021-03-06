package apps;

import org.jooby.Jooby;

import apps.model.Pet;

public class MixMvcApp extends Jooby {

  {

    /**
     * Before summary.
     */
    use("/api/before")
        /**
         * Get before by id.
         *
         * @param id ID.
         * @return <code>200</code>.
         */
        .get("/:id", req -> {
          int id = req.param("id").intValue();
          DB db = req.require(DB.class);
          Pet result = db.find(id);
          return result;
        });

    use(PetMvc.class);

    /**
     * After summary.
     */
    use("/api/after")
        /**
         * Get after by id.
         *
         * @param id ID.
         * @return <code>200</code>.
         */
        .get("/:id", req -> {
          int id = req.param("id").intValue();
          DB db = req.require(DB.class);
          Pet result = db.find(id);
          return result;
        });
  }
}
